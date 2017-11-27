//package com.example.demo.DataLoader;
//
//
//import com.example.demo.Entity.UserRole;
//import com.example.demo.Repository.RoleRepository;
//import com.example.demo.Repository.UserRepository;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//
//
//
//
//@Component
//public class DataLoader implements CommandLineRunner {
//
//   @Autowired
//    UserRepository userRepository;
//
//   @Autowired
//    RoleRepository roleRepository;
//
//    @Override
//    public void run(String... strings) throws Exception {
//
//
//
//        System.out.println("Loading data . . .");
//
//        roleRepository.save(new UserRole("JOBSEEKER"));
//        roleRepository.save(new UserRole("RECRUITER"));
//
//        UserRole recruiterRole = roleRepository.findByRole("RECRUITER");
//        UserRole userRole = roleRepository.findByRole("JOBSEEKER");
////        System.out.println("Loading Data ..........");
////
////      roleRepository.save(new UserRole("JOBSEEKER"));
////
////      roleRepository.save(new UserRole("RECRUITER"));
////
////
////        UserRole jobseeker= roleRepository.findByRole ( "JOBSEEKER" );
////
////        UserRole recruiter= roleRepository.findByRole ( "RECRUITER" );
////
////        UserData user = new UserData("yonatan","email@email.com","Degree Type","university","jobtitle","mycomapnay","duty","skill","username","password");
////    // user.addRole(jobseeker);
////
////      Set<UserRole> userRoleSet = new HashSet<>();
////      userRoleSet.add(jobseeker);
////      user.setRoles(userRoleSet);
////      userRepository.save(user);
////
////
////        UserData user2 = new UserData("yonatan","email@email.com","Degree Type","university","jobtitle","mycomapnay","duty","skill","recruiter","password");
////
////
////        //user2.addRole(recruiter);
////        Set<UserRole> userRoleSet1 = new HashSet<> (  );
////
////        userRoleSet1.add ( recruiter );
////        user.setRoles (userRoleSet );
////        user2.setRoles ( userRoleSet1 );
////
////        userRepository.save ( user2 );
//
//
//    }
//}
