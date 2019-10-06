package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dao.PlayerDao;
import com.model.Player;

@Controller
public class MainRestController {
    @Autowired
    private PlayerDao giamkhaoDaoList;
    //private GiamkhaoDao giamkhaoDao;
    @RequestMapping("/hello")
    @ResponseBody
    public String welcome() {
    	System.out.println("ok");
        return "Welcome to Loc Pham.";
    }

    @RequestMapping(value = "/players", 
            method = RequestMethod.GET, 
            produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public List <Player> getGiam() {
        List <Player> list = giamkhaoDaoList.getAllgiamkhao();
        return list;
    }
    
    @RequestMapping(value = "/getplayers", method = RequestMethod.GET)
    public String getUsers(Model model) throws Exception{
        List<Player> list = giamkhaoDaoList.getAllgiamkhao();
        //UserListContainer userList = new UserListContainer();
        //userList.setUsers(users);
        model.addAttribute("List", list);
        return "showplayers";
    }

    @RequestMapping(value="/save",
    		method = RequestMethod.POST)
    public String save(@ModelAttribute("command") Player giam) {
    	giamkhaoDaoList.addPlayer(giam);
    	return "redirect:/viewgiam";
    }
    
    @RequestMapping(value = "/player/{ID}", 
            method = RequestMethod.GET, 
            produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public Player getPlayer(@PathVariable("ID") int ID) {
        //return giamkhaoDao.getGiamkhao(ID);
    	System.out.println("Test ID 111");
    	return giamkhaoDaoList.getPlayer(ID);
    }
    
    @RequestMapping(value="/player",
    		method = RequestMethod.GET,
    		produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public Player getGiamkhao1(@RequestParam("ID") int ID) {
    	System.out.println("Test ID Player");
    	return giamkhaoDaoList.getPlayer(ID);
    }
    
//    @RequestMapping(value="/giamkhao1",
//    		method = RequestMethod.GET,
//    		produces = { MediaType.APPLICATION_JSON_VALUE })
//    @ResponseBody
//    public Giamkhao getGiamkhao2(@RequestParam("ID") int ID,@RequestParam("Age") int Age) {
//    	System.out.println("Test ID va Age");
//    	//return giamkhaoDao.getGiamkhao1(ID,Age);
//    	return giamkhaoDaoList.getGiamkhao1(ID, Age);
//    }
//    
//    @RequestMapping(value="/giamkhao2",
//    		method = RequestMethod.GET,
//    		produces = { MediaType.APPLICATION_JSON_VALUE })
//    @ResponseBody
//    public Giamkhao getGiamkhao3(@RequestParam("Age") int Age,@RequestParam("name") String name) {
//    	System.out.println("Test Age va Name");
//    	System.out.println("Age:"+giamkhaoDaoList.getGiamkhao2(Age, name).getAge());
//    	return giamkhaoDaoList.getGiamkhao2(Age,name);
//    }
    
 
    @RequestMapping(value = "/playerAdd", 
            method = RequestMethod.POST, 
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public void addPlayer(@RequestBody Player giam) {
        giamkhaoDaoList.addPlayer(giam);
    }
    
    @RequestMapping(value = "/player", 
            method = RequestMethod.PUT, 
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Player updateGiamkhao(@RequestBody Player giam) {
 
        return giamkhaoDaoList.updatePlayer(giam);
    }
 
    @RequestMapping(value = "/player/{ID}", 
            method = RequestMethod.DELETE, 
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public void deleteGiamkhao(@PathVariable("ID") int ID) {
        giamkhaoDaoList.deletePlayer(ID);;
    }
 
}
