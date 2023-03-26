package com.bilgeadam.proje.controller;

import com.bilgeadam.proje.dto.CommentDto;
import com.bilgeadam.proje.dto.UserDto;
import com.bilgeadam.proje.service.CommentService;
import com.bilgeadam.proje.service.FoodService;
import com.bilgeadam.proje.service.UserService;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.Principal;
import java.util.UUID;

@Controller
//@RequestMapping("/customer")
public class CustomerController {
    private final UserService userService;
    private final FoodService foodService;
    private final CommentService commentService;

    public CustomerController(UserService userService,
                              FoodService foodService,
                              CommentService commentService) {
        this.userService = userService;
        this.foodService = foodService;
        this.commentService = commentService;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @RequestMapping(value = "/profile", method = {RequestMethod.GET, RequestMethod.POST})
    public String showProfilePage(Principal principal, Model model) {

        UserDto user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);

        return "customer/Profile";
    }

    @RequestMapping(value = "/profile-modify", method = {RequestMethod.GET, RequestMethod.POST})
    public String showProfileModifyPage(Principal principal, Model model) {

        UserDto user = userService.findByUsername(principal.getName());
        user.setPassword("");
        model.addAttribute("user", user);

        return "customer/ProfileModify";
    }

    @RequestMapping("/profile-modify-action")
    public String profileModifyAction(@Valid @ModelAttribute("user") UserDto updatedUser,
                                      BindingResult bindingResult,
                                      Principal principal) {

        if (bindingResult.hasFieldErrors("email") || bindingResult.hasFieldErrors("password")
                || bindingResult.hasFieldErrors("phoneNumber")) {
            return "redirect:/profile-modify?error";
        }

        UserDto userDto = userService.findByUsername(principal.getName());
        userDto.setEmail(updatedUser.getEmail());
        userDto.setPassword(updatedUser.getPassword());
        userDto.setPhoneNumber(updatedUser.getPhoneNumber());
        userService.saveUser(userDto);

        return "redirect:/profile?updated";
    }

    @RequestMapping(value = "/payment", method = {RequestMethod.GET, RequestMethod.POST})
    public String showPaymentPage(@RequestParam("foodId") UUID foodId,
                                  Model model,
                                  HttpSession session) {

        model.addAttribute("food", foodService.findById(foodId));
        session.setAttribute("price", foodService.findById(foodId).getPrice());

        return "customer/Payment";
    }

    @GetMapping("/getUserById/{id}")
    UserDto getUserById(@PathVariable UUID id) {

        return userService.findById(id);
    }


    @RequestMapping(value = "/comments/{foodId}", method = {RequestMethod.GET, RequestMethod.POST})
    public String selectFoodID(@PathVariable("foodId") UUID foodId,
                               HttpSession session) {

        session.setAttribute("foodId", foodId);
        return "redirect:/comments";
    }

    @RequestMapping(value = "/comments", method = {RequestMethod.GET, RequestMethod.POST})
    public String showCommentPage(Model model, HttpSession session) {

        UUID foodId = session.getAttribute("foodId") == null ? UUID.fromString("") : (UUID) session.getAttribute("foodId");
        model.addAttribute("food", foodService.findById(foodId));

        return "customer/Comments";
    }

    @RequestMapping(value = "/post-comments")
    public String postComments(@RequestParam("foodId") UUID foodId,
                               @RequestParam("comment") String postedComment,
                               Principal principal) {

        CommentDto commentDto = new CommentDto();
        commentDto.setComment(postedComment);
        commentDto.setPostedBy(principal.getName());
        commentDto.setFoodId(foodId);

        commentService.saveComment(commentDto);

        return "redirect:/comments?posted";
    }
}