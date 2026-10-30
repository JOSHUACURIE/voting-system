package com.voting.system.politicalparties.dto;

import  jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public  record CreatePPartyRequest(

 @NotBlank(message = "name is required") 
 @Size(max = 100)  
String name,
@NotBlank(message = "motto is required")
String motto,
@NotBlank(message = "party leader is reqyure")
String partyLeader,
@NotBlank(message = "party description is required")
String description
) {
}