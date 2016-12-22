package com.scs.action;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scs.model.Product;
import com.scs.service.ProductService;

public class ProductAction extends ActionSupport{
    
	private int id;
	private int inprice;
    private int outprice;
    private int icost;
    private int advance;
    
	ProductService ps ;
	Map<String,Object> request;

	@SuppressWarnings("unchecked")
	public ProductAction() {
		request = (Map<String, Object>) ActionContext.getContext().get(
		"request");
	}

	public String productParamSet() {
		List<Product> list = ps.findProduct("from Product");
        request.put("list", list);
		return "productParamSet";
	}

	public String productParamUpdate() {
		Product product = ps.getProduct(Product.class, id);
		product.setIcost(icost);
		product.setInprice(inprice);
		product.setAdvance(advance);
		product.setOutprice(outprice);
        ps.updateProduct(product);
        

		return "productParamUpdate";
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getInprice() {
		return inprice;
	}

	public void setInprice(int inprice) {
		this.inprice = inprice;
	}

	public int getOutprice() {
		return outprice;
	}

	public void setOutprice(int outprice) {
		this.outprice = outprice;
	}

	public int getIcost() {
		return icost;
	}

	public void setIcost(int icost) {
		this.icost = icost;
	}

	public int getAdvance() {
		return advance;
	}

	public void setAdvance(int advance) {
		this.advance = advance;
	}
	
	public ProductService getPs() {
		return ps;
	}
    @Resource(name="productService")
	public void setPs(ProductService ps) {
		this.ps = ps;
	}

}
