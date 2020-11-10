package com.dto;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiModelProperty;

/**
 *功能描述
 * @author 老默
 * @date 2020/5/8
 * @time 12:13
 * @return
 */
public class PageDTO {

    public <T> Page<T> createPage() {
        return new Page<>(getCurrent(), getSize());
    }

    public PageDTO() {
        this.current = 1L;
        this.size = 10L;
    }

    public PageDTO(Long current, Long size) {
        this.current = current;
        this.size = size;
    }

    @ApiModelProperty(value = "当前页，默认1")
    private Long current;
    @ApiModelProperty(value = "每页显示数，默认10")
    private Long size;

    public Long getCurrent() {
        return current == null ? 1 : current;
    }

    public void setCurrent(Long current) {
        this.current = current;
    }

    public Long getSize() {
        return size == null ? 10 : size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "PageDTO{" +
                "current=" + current +
                ", size=" + size +
                '}';
    }
}
