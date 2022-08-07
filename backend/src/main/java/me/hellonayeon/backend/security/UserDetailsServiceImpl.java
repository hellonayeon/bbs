package me.hellonayeon.backend.security;

import java.util.Date;
import me.hellonayeon.backend.member.dao.MemberDao;
import me.hellonayeon.backend.member.domain.Member;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final MemberDao memberDao;

    public UserDetailsServiceImpl(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    // username = User (id)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("UserDetailsServiceImpl loadUserByUsername " + new Date());

        Member member = memberDao.findById(username);
        if (member == null) {
            throw new UsernameNotFoundException(String.format("'%s'는 존재하지 않는 사용자입니다.", username));
        }

        return new UserDetailsImpl(member);
    }
}
