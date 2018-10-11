package com.dreams.user.client;

import com.dreams.thrift.user.dto.UserDTO;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

public abstract class LoginFilter implements Filter {

    // google guava 创建客户端缓存
    private static Cache<String, UserDTO> cache =
            CacheBuilder.newBuilder().maximumSize(10000)
                    .expireAfterWrite(3, TimeUnit.MINUTES)
                    .build();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request1, ServletResponse response1, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) request1;
        HttpServletResponse response = (HttpServletResponse) response1;

        String token = request.getParameter("token");
        if (StringUtils.isBlank(token)) {
            // 先从cookie里取，不是所有的请求都会带着token
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie c : cookies) {
                    if (c.getName().equals("token")) {
                        token = c.getValue();
                    }
                }
            }
        }

        UserDTO userDTO = null;
        if (StringUtils.isNotBlank(token)) {
            //先从客户端缓存中取
            userDTO = cache.getIfPresent(token);
            if (userDTO == null) {
                //如果客户端缓存为空，再从server取
                userDTO = requestUserInfo(token);
                if (userDTO != null) {
                    //成功获取userDTO后，写入客户端缓存
                    cache.put(token, userDTO);
                }
            }
        }
        if (userDTO == null) {
            response.sendRedirect("http://localhost:8001/user/login");
            return;
        }

        login(request, response, userDTO);

        chain.doFilter(request, response);

    }

    /**
     * 其它用户的处理逻辑（用户已经登录成功）
     *
     * @param request
     * @param response
     * @param userDTO
     */
    protected abstract void login(HttpServletRequest request, HttpServletResponse response, UserDTO userDTO);


    private UserDTO requestUserInfo(String token) {
        String url = "http://localhost:8001/user/authentication";

        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);
        post.addHeader("token", token);
        InputStream inputStream = null;
        try {
            HttpResponse response = client.execute(post);
            if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
                throw new RuntimeException("request user info failed! StatusLine:" + response.getStatusLine());
            }
            inputStream = response.getEntity().getContent();
            byte[] tmp = new byte[1024];
            StringBuilder sb = new StringBuilder();
            int len = 0;
            while ((len = inputStream.read(tmp)) > 0) {
                sb.append(new String(tmp, 0, len));
            }

            UserDTO userDTO = new ObjectMapper().readValue(sb.toString(), UserDTO.class);

            return userDTO;

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    // 此处无论什么异常都不在意，只是将其捕获住即可
                    e.printStackTrace();
                }
            }
        }

        return null;
    }

    @Override
    public void destroy() {

    }
}
