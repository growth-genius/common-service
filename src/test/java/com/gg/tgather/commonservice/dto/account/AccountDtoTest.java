package com.gg.tgather.commonservice.dto.account;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AccountDtoTest {


    @Test
    @DisplayName("생성 테스트")
    void accountDtoCreateTest() throws Exception {
        // given
        AccountDto accountDto = AccountDto.create();
        // when

        // then
        assertNotNull(accountDto);
    }
}