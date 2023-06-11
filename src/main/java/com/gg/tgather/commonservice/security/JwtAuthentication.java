package com.gg.tgather.commonservice.security;

public record JwtAuthentication(Long id, String accountId, String email, String nickname) {}
