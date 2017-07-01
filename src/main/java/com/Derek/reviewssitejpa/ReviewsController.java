package com.Derek.reviewssitejpa;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReviewsController {
	@Resource
	ReviewRepository reviewRepo;
	
	@Resource
	GenreRepository genreRepo;

	@RequestMapping("/reviews")
	public String fetchReviews(Model model) {
		model.addAttribute("reviewsAsCollection", reviewRepo.findAll());
		return "reviews";
	}
	
	@RequestMapping("/onereview")
    public String fetchOne(@RequestParam(value="id") Long id, Model model) {
         model.addAttribute("onereview", reviewRepo.findOne(id));
         return "onereview";
         
     }
	
	@RequestMapping("/genreList")
	public String fetchGenre(Model model) {
		model.addAttribute("genreAsCollection", genreRepo.findAll());
		return "genreList";
	}
	
	@RequestMapping("/onegenre")
    public String fetchOneGenre(@RequestParam(value="id") Long id, Model model) {
         model.addAttribute("onegenre", genreRepo.findOne(id));
         return "onegenre";
         
     }
	
	
	
	
}
