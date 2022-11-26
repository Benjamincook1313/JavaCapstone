package com.Capstone.JavaCapstone.dtos;

import com.Capstone.JavaCapstone.entity.User;
import com.Capstone.JavaCapstone.entity.listTypes.ListType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListDto {

  private Long id;
  private String title;
  private ListType type;
  private User owner;
}
