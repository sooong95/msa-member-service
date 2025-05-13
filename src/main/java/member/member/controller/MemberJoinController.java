package member.member.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import member.member.dto.join.MemberJoinDto;
import member.member.dto.join.ShopMemberJoinDto;
import member.member.service.join.MemberJoinService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

import static org.springframework.http.HttpStatus.CREATED;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/member/join")
public class MemberJoinController {

    private final MemberJoinService memberJoinService;

    @PostMapping
    public ResponseEntity<String> memberSave(@Valid @RequestBody MemberJoinDto dto) throws ExecutionException, InterruptedException {

        memberJoinService.memberSave(dto);
        return new ResponseEntity<>("MEMBER 가입 성공!", CREATED);
    }

    @PostMapping("/shop")
    public ResponseEntity<String> shopMemberSave(@Valid @RequestBody ShopMemberJoinDto dto) throws ExecutionException, InterruptedException {

        memberJoinService.shopMemberSave(dto);
        return new ResponseEntity<>("SHOP MEMBER 가입 성공!", CREATED);
    }
}
