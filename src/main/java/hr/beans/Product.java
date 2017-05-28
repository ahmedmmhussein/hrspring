package hr.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "products")

public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "productId")
	private int productId;
	@NotNull
	@Size(min = 2, max = 20, message = "{name.size}")
	@Column(name = "productName")
	private String productName;
	@NotNull
	@Size(min = 4, max = 20, message = "{jobTitle.size}")
	@Column(name = "productCode")
	private String productCode;
	@NotNull
	@Column(name = "releaseDate")
	private Date releaseDate;
	@NotNull
	@Size(min = 2, max = 20, message = "{name.size}")
	@Column(name = "description")
	private String description;
	@NotNull
	@Column(name = "price")
	private long price;
	@NotNull
	@Column(name = "starRating")
	private long starRating;
	@NotNull
	@Size(min = 4, max = 20, message = "{jobTitle.size}")
	@Column(name = "imageUrl")
	private String imageUrl;

	public Product() {
		super();
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public long getStarRating() {
		return starRating;
	}

	public void setStarRating(long starRating) {
		this.starRating = starRating;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
}
