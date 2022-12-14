package me.hellonayeon.backend.member.controller;

import java.util.Date;
import javax.validation.Valid;
import me.hellonayeon.backend.member.dto.request.JoinRequest;
import me.hellonayeon.backend.member.dto.request.LoginRequest;
import me.hellonayeon.backend.member.dto.response.JoinResponse;
import me.hellonayeon.backend.member.dto.response.LoginResponse;
import me.hellonayeon.backend.member.exception.MemberException;
import me.hellonayeon.backend.member.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class MemberController {

	private final MemberService service;

	public MemberController(MemberService service) {
		this.service = service;
	}

	@GetMapping
	public ResponseEntity<?> checkIdDuplicate(@RequestParam String id) {
		System.out.println("UserController checkIdDuplicate " + new Date());

		HttpStatus status = service.checkIdDuplicate(id);
		return new ResponseEntity<>(status);
	}

	@PostMapping("/join")
	public ResponseEntity<JoinResponse> join(@Valid @RequestBody JoinRequest req) {
		System.out.println("UserController join " + new Date());

		return ResponseEntity.ok(service.join(req));
	}

	@PostMapping("/login")
	public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest req) {
		System.out.println("UserController login " + new Date());

		return ResponseEntity.ok(service.login(req));
	}


	/* ?????? DTO ?????? ???????????? ????????? */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
		System.out.println("UserController handleMethodArgumentNotValidException " + new Date());

		BindingResult bs = e.getBindingResult();
		StringBuilder sb = new StringBuilder();
		bs.getFieldErrors().forEach(err -> {
			sb.append(String.format("[%s]: %s.\n????????? ???: %s",
						err.getField(), err.getDefaultMessage(), err.getRejectedValue()));
		});

		// Map ?????? ???????????? ??????????????? ???????????? ??? ????????? ??? !
		return new ResponseEntity<>(sb.toString(), HttpStatus.BAD_REQUEST);
	}

	/* ????????? ?????? ?????? ???????????? ????????? */
	@ExceptionHandler(MemberException.class)
	public ResponseEntity<?> handleUserException(MemberException e) {
		System.out.println("UserController handlerUserException " + new Date());

		return new ResponseEntity<>(e.getMessage(), e.getStatus());
	}
}


