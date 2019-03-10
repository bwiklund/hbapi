package com.daisyowl.hbapi;

import com.daisyowl.hbapi.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

@Component
@Order(1)
public class UserFilter implements Filter {
  @Autowired
  HBRequest hbRequest;

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    User user = new User();
    user.username = "Ben";
    hbRequest.user = user;
    chain.doFilter(request, response);
  }

}
