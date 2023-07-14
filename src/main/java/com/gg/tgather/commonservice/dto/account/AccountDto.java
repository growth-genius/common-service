package com.gg.tgather.commonservice.dto.account;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gg.tgather.commonservice.enums.AccountRole;
import com.gg.tgather.commonservice.enums.LoginType;
import com.gg.tgather.commonservice.enums.TravelTheme;
import java.time.LocalDateTime;
import java.util.Set;
import lombok.Data;

@Data
public class AccountDto {

    /** 로그인 아이디 */
    protected Long id;
    /** 고유 식별자 */
    protected String accountId;
    /** 이메일 */
    protected String email;
    /** 사용자 이름 */
    protected String userName;
    /* 사용자 별명 */
    protected String nickname;
    /* 패스워드*/
    @JsonIgnore
    protected String password;
    /** 가입일자 */
    protected LocalDateTime joinedAt;
    /** 권한 */
    protected Set<AccountRole> roles = Set.of(AccountRole.USER);
    /** 로그인 횟수 */
    protected int loginCount;
    /** 마지막 로그인 일자 */
    protected LocalDateTime lastLoginAt;
    /** 프로필 이미지 */
    protected String profileImage;
    /** 로그인 타입 */
    protected LoginType loginType;
    /** 접속 토큰 */
    protected String accessToken;
    /** 재발급 토큰 */
    protected String refreshToken;
    /** fcm 토큰 */
    protected String fcmToken;
    /** 나이 */
    protected int age;
    /** 생년월 */
    protected int birth;
    /** 여행 테마 */
    protected Set<TravelTheme> travelThemes;

    public static AccountDto create() {
        return new AccountDto();
    }

}
