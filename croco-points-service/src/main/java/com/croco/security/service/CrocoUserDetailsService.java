package com.croco.security.service;

import com.croco.bean.DAOUser;
import com.croco.repository.api.CrocoGeneralRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CrocoUserDetailsService implements UserDetailsService {

    @Autowired
    CrocoGeneralRepository crocoGeneralRepository;


    @Override
    public UserDetails loadUserByUsername(String usernameFromRequest) throws UsernameNotFoundException {

        DAOUser userObjFromDB=crocoGeneralRepository.findByUsername(usernameFromRequest);
        List<SimpleGrantedAuthority> rolesLst=null;
        if(userObjFromDB!=null){
                rolesLst= Arrays.asList(new SimpleGrantedAuthority(userObjFromDB.getRoles()));
                return new User(userObjFromDB.getUsername(),userObjFromDB.getPassword(),rolesLst);
        }
        else{
            throw new UsernameNotFoundException("usernamenot found in DB !"+usernameFromRequest);
        }
        /*if(username!=null && username.equalsIgnoreCase("selva")){
            rolesLst= Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
                return new User("selva","$2a$10$sBWP2TBC4UUR2M76heTxHewHOIKgWkR9JFOx.3m7auLwLdPTBZCo6",rolesLst);
        }
        if(username!=null && username.equalsIgnoreCase("pandy")){
            rolesLst= Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
            return new User("pandy","$2a$10$JvEFM61j4.UbYOds0oiyFegfyCTapDsKBoiPhHACp3VvDh08Ub7.K",rolesLst);
        }*/

    }
}
