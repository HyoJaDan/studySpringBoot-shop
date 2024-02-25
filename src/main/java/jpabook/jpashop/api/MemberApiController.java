package jpabook.jpashop.api;

import jakarta.validation.Valid;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.service.MemberService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//@ResponseBody와 Controller을 합친거. data 자체를 JSON으로 보낼때 사용한다.
@RestController
@RequiredArgsConstructor
public class MemberApiController {
    private final MemberService memberService;

    //회원 등록 API
    //RequestBody : JSON으로 온 Body를 Member에 Mapping 해서 값을 넣어준다.
    //Valid : Entity 안에 있는것을 validation 해준다.
    @PostMapping("/api/v1/members")
    public CreateMemberResponse saveMemberV1(@RequestBody @Valid Member member){
        Long id = memberService.join(member);
        return new CreateMemberResponse(id);
    }
    @Data
    static class CreateMemberResponse{
        private Long id;

        public CreateMemberResponse(Long id) {
            this.id = id;
        }
    }
}
