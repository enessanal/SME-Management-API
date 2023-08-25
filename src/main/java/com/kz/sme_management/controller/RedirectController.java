package com.kz.sme_management.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedirectController
{
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public void redirectToMain(HttpServletResponse httpServletResponse)
    {
        httpServletResponse.setHeader("Location", "/index.html");
        httpServletResponse.setStatus(302);
    }
}
