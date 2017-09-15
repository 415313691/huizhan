package com.huizhan.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.huizhan.entities.HzProduction;
import com.huizhan.service.ProductService;
import com.huizhan.util.Page;
import com.opensymphony.xwork2.ActionContext;

@Controller("productAction")
@Scope("prototype")
public class ProductAction {
	@Resource
	private ProductService productService;
	
	private String currentPage;
	private HzProduction product;
	private String id;
	
	public String findAllProduct(){
		int pageSize = 10;// 每页显示数据量
        int currentPageNum = 1;// 当前页码

        String currentPage = this.currentPage;
        if (currentPage != null && !"".equals(currentPage)) {
            currentPageNum = Integer.parseInt(currentPage);
        }
        Page page = productService.findAllProduct(currentPageNum, pageSize);
        ActionContext.getContext().put("page",page);
        return "products_ok";
	}
	
	public String beforeEdit_product(){
		if(!"".equals(id)&&id!=null){
			HzProduction product =productService.findProductById(id);
			ActionContext.getContext().put("product",product);
		}
		return "before_ok";
	}
	
	public String saveProduct(){
		productService.saveProduct(product);
		return "save_ok";
	}
	
	public String deleteProduct(){
		productService.delProduct(id);
		return "del_ok";
	}
	public String getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}
	public HzProduction getProduct() {
		return product;
	}
	public void setProduct(HzProduction product) {
		this.product = product;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
