package com.retail.basket;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("api/v1/basket")
@AllArgsConstructor
public class BasketController {
    @GetMapping("/session_info")
    public ResponseEntity<Map<String, String>> getSessionId(HttpSession session) {
        Map<String, String> response = new HashMap<>();
        response.put("sessionId", session.getId());
        return ResponseEntity.ok(response);
    }
}
