package com.mapsa.webstore.product;


import com.mapsa.webstore.product.domain.*;
import com.mapsa.webstore.product.repository.CartRepository;
import com.mapsa.webstore.product.repository.CategoryRepository;
import com.mapsa.webstore.product.repository.GroupRepository;
import com.mapsa.webstore.product.repository.ProductRepository;
import com.mapsa.webstore.product.security.RegisterRequestDto;
import com.mapsa.webstore.product.security.UserRepository;
import com.mapsa.webstore.product.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@RequiredArgsConstructor
//@EnableJdbcHttpSession
public class ProductApplication implements CommandLineRunner {


     private final CategoryRepository categoryRepository ;
     private final UserService userService;
     private final GroupRepository groupRepository;
     private final ProductRepository productRepository;

     private final User user;
     private final OrderTbl orderTbl;
     private final Factor factor;
    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
         Category categorytemp=new Category();
         GroupTbl groupTbltemp=new GroupTbl();
          Product producttemp=new Product();
       categorytemp.setTitle("c1")
               .setDiscription("good life with this product.");
      categoryRepository.save(categorytemp);
      groupTbltemp.setCategory(categorytemp)
               .setName("g1")
               .setDescription("this product have best viamin.");
        groupRepository.save(groupTbltemp);
        producttemp.setAvatar("avatar1")
                .setGroupTbl(groupTbltemp)
                .setName("p1")
                .setPrice(200000l)
                .setStock(4700000l);
       Product product1=productRepository.save(producttemp);
       ///////////////////////////////////
        ////////////////////
        //////////////////

        Category categorytemp2=new Category();
        GroupTbl groupTbltemp2=new GroupTbl();
        Product producttemp2=new Product();
        categorytemp2.setTitle("c2")
                .setDiscription("good life with this product2222.")
        ;
       categoryRepository.save(categorytemp2);
        groupTbltemp2.setCategory(categorytemp2)
                .setName("g2")
                .setDescription("this product have best viamin.222222");
       groupRepository.save(groupTbltemp2);
        producttemp2.setAvatar("avatar1")
                .setGroupTbl(groupTbltemp2)
                .setName("p2")
                .setPrice(200000l)
                .setStock(4700000l);
        productRepository.save(producttemp2);

        Category categorytemp4=new Category();
        GroupTbl groupTbltemp4=new GroupTbl();
        Product producttemp4=new Product();
        categorytemp4.setTitle("c3")
                .setDiscription("good life with this product2222.")
        ;
        categoryRepository.save(categorytemp4);
        groupTbltemp4.setCategory(categorytemp4)
                .setName("g3")
                .setDescription("this product have best viamin.222222");
        groupRepository.save(groupTbltemp4);
        producttemp4.setAvatar("avatar1")
                .setGroupTbl(groupTbltemp4)
                .setName("p3")
                .setPrice(200000l)
                .setStock(4700000l);
        productRepository.save(producttemp4);

        Category categorytemp3=new Category();
        GroupTbl groupTbltemp3=new GroupTbl();
        Product producttemp3=new Product();
        categorytemp3.setTitle("c4")
                .setDiscription("good life with this product2222.")
        ;
        categoryRepository.save(categorytemp3);
        groupTbltemp3.setCategory(categorytemp3)
                .setName("g4")
                .setDescription("this product have best viamin.222222");
        groupRepository.save(groupTbltemp3);
        producttemp3.setAvatar("avatar1")
                .setGroupTbl(groupTbltemp3)
                .setName("p4")
                .setPrice(200000l)
                .setStock(4700000l);
        productRepository.save(producttemp3);
        RegisterRequestDto registerRequestDto=new RegisterRequestDto().setPassword("22")
                .setUsername("22")
                .setRole("a");
        userService.save(registerRequestDto);
         registerRequestDto=new RegisterRequestDto().setPassword("11")
                .setUsername("11")
                .setRole("a");
        userService.save(registerRequestDto);



    }
}
