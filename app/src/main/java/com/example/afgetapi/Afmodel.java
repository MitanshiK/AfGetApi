// YApi QuickType插件生成，具体参考文档:https://plugins.jetbrains.com/plugin/18847-yapi-quicktype/documentation

package com.example.afgetapi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Afmodel {
    @SerializedName("product_image")
    @Expose
    private String product_image;
    @SerializedName("vendorprice_finalprice")
    @Expose

    private String vendorprice_finalprice;
    @SerializedName("vendorprice_price")
    @Expose
    private String vendorprice_price;
    @SerializedName("vendorprice_shipping")
    @Expose
    private String vendorprice_shipping;

    @SerializedName("product_id")
    @Expose
    private String product_id;

    @SerializedName("product_name")
    @Expose
    private String product_name;
    @SerializedName("brand_key")
    @Expose
    private String brand_key;
    @SerializedName("vendor_sku")
    @Expose
    private String vendor_sku;

    public String getProductImage() {
        return product_image;
    }

    public void setProductImage(String value) {
        this.product_image = value;
    }

    public String getVendorpriceFinalprice() {
        return vendorprice_finalprice;
    }

    public void setVendorpriceFinalprice(String value) {
        this.vendorprice_finalprice = value;
    }


    public String getVendorprice_price() {
        return vendorprice_price;
    }

    public void setVendorprice_price(String value) {
        this.vendorprice_price = value;
    }

    public String getShipping() {
        return vendorprice_shipping;
    }

    public void setShipping(String value) {
        this.vendorprice_shipping = value;
    }

    public String getProductid() {
        return product_id;
    }

    public void setProductid(String value) {
        this.product_id = value;
    }

    public String getProductName() {
        return product_name;
    }

    public void setProductName(String value) {
        this.product_name = value;
    }

    public String getBrandKey() {
        return brand_key;
    }

    public void setBrandKey(String value) {
        this.brand_key = value;
    }

    public String getVendorSku() {
        return vendor_sku;
    }

    public void setVendorSku(String value) {
        this.vendor_sku = value;
    }

}
