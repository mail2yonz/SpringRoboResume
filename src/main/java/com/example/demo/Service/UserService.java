//package com.example.demo.Service;
//
//
//import com.example.demo.Entity.User;
//
//import com.example.demo.Entity.UserRole;
//import com.example.demo.Repository.RoleRepository;
//import com.example.demo.Repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Arrays;
//import java.util.HashSet;
//import java.util.Set;
//
//
//@Service
//public class UserService {
//
//    @Autowired
//    UserRepository userRepository;
//
//    @Autowired
//    RoleRepository roleRepository;
//
//    @Autowired
//    public UserService(UserRepository userRepository) {
//
//        this.userRepository=userRepository;
//    }
//
//    public User findByEmail(String email)
//    {
//        return userRepository.findByEmail ( email );
//    }
//    public Long countByEmail(String email)
//    {
//        return userRepository.countByEmail (  email);
//    }
//
//    public User findByUsername(String username)
//    {
//        return userRepository.findByUsername ( username );
//    }
//
//    public void saveJobSeeker(User user)
//    {
//
//        Set<UserRole> userRoleSet= new HashSet<> (  );
//
//        userRoleSet.add (  roleRepository.findByRole ( "JOBSEEKER" ));
//        user.setRoles (  userRoleSet  );
//      //  user.setEnabled ( true );
//        userRepository.save ( user );
//    }
//
//    public void saveRecruter(User user)
//    {
//
//        Set<UserRole>  userRoleSet= new HashSet<> (  );
//        userRoleSet.add ( roleRepository.findByRole ( "RECRUITER" ) );
//        user.setRoles (  userRoleSet );
//       // user.setEnabled ( true );
//        userRepository.save ( user );
//    }
//
//}
