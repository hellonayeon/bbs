package me.hellonayeon.backend.member.service;

import me.hellonayeon.backend.jwt.JwtTokenUtil;
import me.hellonayeon.backend.member.dao.MemberDao;
import me.hellonayeon.backend.member.dto.param.CreateMemberParam;
import me.hellonayeon.backend.member.dto.request.JoinRequest;
import me.hellonayeon.backend.member.dto.request.LoginRequest;
import me.hellonayeon.backend.member.dto.response.JoinResponse;
import me.hellonayeon.backend.member.dto.response.LoginResponse;
import me.hellonayeon.backend.member.exception.MemberException;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MemberService {

	private final MemberDao dao;
	private final PasswordEncoder encoder;
	private final AuthenticationManager authenticationManager;

	private final JwtTokenUtil jwtTokenUtil;
	private final UserDetailsService userDetailsService;


	public MemberService(MemberDao dao, PasswordEncoder encoder,
		AuthenticationManager authenticationManager,
		JwtTokenUtil jwtTokenUtil,
		UserDetailsService userDetailsService) {
		this.dao = dao;
		this.encoder = encoder;
		this.authenticationManager = authenticationManager;
		this.jwtTokenUtil = jwtTokenUtil;
		this.userDetailsService = userDetailsService;
	}

	public HttpStatus checkIdDuplicate(String id) {
		isExistUserId(id);
		return HttpStatus.OK;
	}

	@Transactional
	public JoinResponse join(JoinRequest req) {

		saveMember(req);
		authenticate(req.getId(), req.getPwd());

		return new JoinResponse(req.getId());
	}

	private void saveMember(JoinRequest req) {
		// ????????? ?????? ??????
		isExistUserId(req.getId());

		// ???????????? ?????? ??????
		checkPwd(req.getPwd(), req.getCheckPwd());

		// ?????? ?????? ??????
		String encodedPwd = encoder.encode(req.getPwd());
		CreateMemberParam param = new CreateMemberParam(req, encodedPwd);

		Integer result = dao.createMember(param);
		if (result == 0) {
			throw new MemberException("?????? ????????? ??????????????????.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public LoginResponse login(LoginRequest req) {
		authenticate(req.getId(), req.getPwd());

		final UserDetails userDetails = userDetailsService.loadUserByUsername(req.getId());
		final String token = jwtTokenUtil.generateToken(userDetails);

		return new LoginResponse(token, req.getId());
	}

	private void authenticate(String id, String pwd) {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(id, pwd));
		} catch (DisabledException e) {
			throw new MemberException("???????????? ?????? ??????????????????.", HttpStatus.BAD_REQUEST);
		} catch (BadCredentialsException e) {
			throw new MemberException("??????????????? ???????????? ????????????.", HttpStatus.BAD_REQUEST);
		}
	}

	private void isExistUserId(String id) {
		Integer result = dao.isExistUserId(id);
		if (result == 1) {
			throw new MemberException("?????? ???????????? ??????????????????.", HttpStatus.BAD_REQUEST);
		}
	}

	private void checkPwd(String pwd, String checkPwd) {
		if (!pwd.equals(checkPwd)) {
			throw new MemberException("??????????????? ???????????? ????????????.", HttpStatus.BAD_REQUEST);
		}
	}
}




