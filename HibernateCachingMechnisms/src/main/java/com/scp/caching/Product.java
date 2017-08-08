package com.scp.caching;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * Enable this to active 2nd level caching
 * @author Progvaltion_11
 *
 */
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)


@Entity
@Table(name="prod_cache")
@NamedQueries({ 
@NamedQuery(name = "HQL_GET_ALL_PRODUCT",query = "from Product"),
@NamedQuery(name = "HQL_GET_ALL_PRODUCT_WITH_ID",query = " from Product s where s.productId = :pid"),
@NamedQuery(name = "HQL_GET_ALL_PRODUCT_WITH_ID_N_NAME",query = " from Product s where s.productName = ? and s.productId = ?")
})


@NamedNativeQueries({
@NamedNativeQuery(name = "SQL_GET_ALL_PRODUCT",query = "select * from prod_cache",resultClass = Product.class

)
})
public class Product {

	@Id
	@GeneratedValue
	private int productId;
	
	@Column
	private String productName;
	
	@Column
	private int productPrice;
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public Product(String productName, int productPrice) {
		super();
		this.productName = productName;
		this.productPrice = productPrice;
	}
	
	public Product(int productid,String productName, int productPrice) {
		super();
		this.productId=productid;
		this.productName = productName;
		this.productPrice = productPrice;
	}
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "\n Product [productName=" + productName + ", productId=" + productId + ", productPrice=" + productPrice
				+ "]";
	}
	
	
	
	

}
