package com.strongscript.earth.controller;

import com.strongscript.earth.coordinates.Coordinates;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainController
{
  @Value("${earth.radius}")
  private double radius;

  @RequestMapping(value = "/earth/findDistance",method = RequestMethod.POST)
  public double findDistance(@RequestBody Coordinates coordinates){

    return radius*Math.acos(Math.sin(Math.toRadians(coordinates.getLatitudeA()))
      *Math.sin(Math.toRadians(coordinates.getLatitudeB()))
      +Math.cos(Math.toRadians(coordinates.getLatitudeA()))
      *Math.cos( Math.toRadians(coordinates.getLatitudeB()))
      *Math.cos( Math.toRadians(coordinates.getLongitudeA())-Math.toRadians(coordinates.getLongitudeB())));
  }
}
