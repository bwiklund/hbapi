package com.daisyowl.hbapi;

import com.daisyowl.hbapi.models.SessionToken;
import com.daisyowl.hbapi.models.SessionTokenRepository;
import com.daisyowl.hbapi.models.User;
import com.daisyowl.hbapi.models.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.util.WebUtils;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
@Order(1)
public class UserFilter implements Filter {
  @Autowired
  private static final Logger LOGGER = LoggerFactory.getLogger(UserFilter.class);

  @Autowired
  HBRequest hbRequest;

  @Autowired
  SessionTokenRepository sessionTokenRepository;

  @Autowired
  UserRepository userRepository;

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    Cookie authCookie = WebUtils.getCookie((HttpServletRequest) request, "hb-auth");
    if (authCookie != null) {
      SessionToken sessionToken = sessionTokenRepository.findByToken(authCookie.getValue());
      if (sessionToken != null) {
        User user = userRepository.findById(sessionToken.userId).get();
        hbRequest.user = user;
        LOGGER.info("Authed user: {}", hbRequest.user);
      }
    }
    chain.doFilter(request, response);
  }

}
