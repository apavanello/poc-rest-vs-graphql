package com.example.poc.middleware;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Slf4j
@Component
public class RequestLoggingFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        
        String path = request.getRequestURI();
        
        // Filter out H2 console or common static resources to keep log clean if needed
        if (!path.startsWith("/h2-console") && !path.contains("favicon")) {
            log.info(">>> INCOMING REQUEST: [{}] {}", request.getMethod(), path);
        }
        
        long startTime = System.currentTimeMillis();
        filterChain.doFilter(request, response);
        long duration = System.currentTimeMillis() - startTime;
        
        if (!path.startsWith("/h2-console") && !path.contains("favicon")) {
             log.info("<<< COMPLETED REQUEST: [{}] {} (Status: {}, Time: {}ms)", 
                     request.getMethod(), path, response.getStatus(), duration);
        }
    }
}
