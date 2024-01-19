package com.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


	@Entity
	@Table(name = "orders")
		public class Order {
			@Id
			@GeneratedValue(strategy =GenerationType.IDENTITY)
			@Column
			private int id;
			@Column
			private int userid;
			@Column
			private int  productid;
			@Column
			private int quantity;
			
			public int getId() {
				return id;
			}
			public void setId(int id) {
				this.id = id;
			}
			public int getUserid() {
				return userid;
			}
			public void setUserid(int userid) {
				this.userid = userid;
			}
			public int getProductid() {
				return productid;
			}
			public void setProductid(int productid) {
				this.productid = productid;
			}
			public int getQuantity() {
				return quantity;
			}
			public void setQuantity(int quantity) {
				this.quantity = quantity;
			}
			
			@Override
		public String toString() {
	return "Order [id=" + id + ", userid=" + userid + ","
			+ " productid=" + productid + ", quantity=" + quantity
						+ "]";
			}
			
			
			

}
