package com.kz.sme_management.model.util;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Optional;

public class Paging
{
    private final int[] sizes;
    private final String[] sortBys;

    private int number;
    private int size;
    private String sortBy;
    private Sort.Direction direction;

    public Paging(int[] sizes, String[] sortBys)
    {
        this.sizes = sizes;
        this.sortBys = sortBys;
    }

    public Pageable getPageable(Optional<Integer> number, Optional<Integer> size, Optional<String> sortBy, Optional<String> direction)
    {
        this.direction = direction.isPresent() && direction.get().equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;
        this.number = Math.max((number.orElse(1) - 1), 0);
        this.size = size.orElse(this.sizes[0]);
        this.sortBy = sortBy.orElse(this.sortBys[0]);

        {
            boolean found = false;
            for (int i = 0; i < sortBys.length; i++)
            {
                if (this.sortBys[i].equals(this.sortBy))
                {
                    this.sortBy = this.sortBys[i];
                    found = true;
                    break;
                }
            }
            this.sortBy = found ? this.sortBy : sortBys[0];
            this.direction = found ? this.direction: Sort.Direction.ASC;
        }

        {
            boolean found = false;
            for (int i = 0; i < sizes.length; i++) {
                if (this.sizes[i] == this.size) {
                    this.size = this.sizes[i];
                    found = true;
                    break;
                }
            }
            this.size = found ? this.size : sizes[0];
        }


        return PageRequest.of(this.number, this.size, Sort.by(this.direction, this.sortBy));
    }
}
