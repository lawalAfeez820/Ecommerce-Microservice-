package com.lawal.ecommerce.handler;


import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Builder
@Data
public class ErrorResponse {

    private Set<String> error;
}
