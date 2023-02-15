package modul2.edu.udemy.service.impls;

import lombok.RequiredArgsConstructor;
import modul2.edu.udemy.exception.NotFoundException;
import modul2.edu.udemy.repository.UserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findUserByEmail(username)
                .orElseThrow(()-> new NotFoundException("No such a user found with "+ username));
    }
}
