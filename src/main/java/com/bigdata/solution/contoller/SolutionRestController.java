package com.bigdata.solution.contoller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bigdata.solution.bean.ImdbBean;
import com.bigdata.solution.bean.SentimentScoreBean;
import com.bigdata.solution.bean.SentimentScoreCountPercent;
import com.bigdata.solution.bean.TweetBean;
import com.bigdata.solution.service.IMDBService;
import com.bigdata.solution.service.SentimentService;
import com.bigdata.solution.service.TwitterService;

@Controller
public class SolutionRestController {
	
	@Autowired
	private TwitterService twitterService;
	
	@Autowired
	private SentimentService sentimentService;
	
	@Autowired
	private IMDBService imdbService;
	
	@RequestMapping("/")
	public ModelAndView getHomePage(){
		
		ModelAndView modelAndView = new ModelAndView("body");
		modelAndView.addObject("showTable" , false);
		return modelAndView;
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public ModelAndView search(HttpServletRequest request){
		
		String searchValue = request.getParameter("q");
		List<TweetBean> tweetBeanList = twitterService.getTwitterResponse(searchValue);
		List<SentimentScoreBean> sentimentScoreBeanList = sentimentService.processTweets(tweetBeanList);
		List<SentimentScoreCountPercent> sentimentScoreCountPercentList = sentimentService.tweetAnalysis(sentimentScoreBeanList);
		ImdbBean imdbBean = imdbService.getMoviesRating(searchValue);
		
		ModelAndView modelAndView = new ModelAndView("body");
		modelAndView.addObject("sentimentScoreBeanList", sentimentScoreBeanList);
		modelAndView.addObject("showTable" , true);
		modelAndView.addObject("key", searchValue);
		modelAndView.addObject("sentimentScoreCountPercentList", sentimentScoreCountPercentList);
		modelAndView.addObject("imdbBean", imdbBean);
		return modelAndView;
	}
	
	
	@RequestMapping(value = "/master", method = RequestMethod.GET)
	public ModelAndView getMasterData() {
		ModelAndView modelAndView = new ModelAndView("master");
		modelAndView.addObject("showTable" , false);
		return modelAndView;
	}
	
	@RequestMapping("/test")
	public ResponseEntity<String> getData(){
		
		String jsonOutput = "Hi, It is working";
		return new ResponseEntity<String>(jsonOutput, HttpStatus.OK);
		
	}
	
	@RequestMapping("/getTwitterApiData")
	public ResponseEntity<List<TweetBean>> getTwitterApiData(@RequestParam("str") String searchKey){
		
		List<TweetBean> tweetBeanList = twitterService.getTwitterResponse(searchKey);
		sentimentService.processTweets(tweetBeanList);
		return new ResponseEntity<List<TweetBean>>(tweetBeanList, HttpStatus.OK);
	}	
	
	
	

}
