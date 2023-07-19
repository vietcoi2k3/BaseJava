package com.apec.pos.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.apec.pos.entity.search.TableSearch;
import com.apec.pos.enu.ErrorCode;
import com.apec.pos.response.Response;
import com.apec.pos.service.TableService;



@RestController
@RequestMapping("/table")
public class TableController {
	
	@Autowired
	private TableService tableService;
	
	@RequestMapping(value = "/search", method = RequestMethod.POST, name = "Search danh sách bàn")
	public Response searchTable(@RequestBody TableSearch search) {
		return new Response(true, "Danh sách bàn",  ErrorCode.SUCCESS, tableService.searchTable(search));
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET, name = "Chi tiết bàn")
	public Response detailTable(@RequestParam int id) {
		return new Response(true, "Chi tiết bàn", ErrorCode.SUCCESS, tableService.findOne(id));
	}
}
