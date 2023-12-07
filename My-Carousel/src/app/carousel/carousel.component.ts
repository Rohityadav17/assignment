import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-carousel',
  templateUrl: './carousel.component.html',
  styleUrls: ['./carousel.component.css']
})
export class CarouselComponent implements OnInit {
  @Input() images: string[] = ['https://images.pexels.com/photos/9992332/pexels-photo-9992332.jpeg?auto=compress&cs=tinysrgb&w=600','https://images.pexels.com/photos/9992330/pexels-photo-9992330.jpeg?auto=compress&cs=tinysrgb&w=600','https://images.pexels.com/photos/9992435/pexels-photo-9992435.jpeg?auto=compress&cs=tinysrgb&w=600','https://images.pexels.com/photos/4676400/pexels-photo-4676400.jpeg?auto=compress&cs=tinysrgb&w=600']; 
  currentIndex = 0;

  constructor() {}

  ngOnInit(): void {}

  getPreviousImage(): string {
    return this.images[(this.currentIndex - 1 + this.images.length) % this.images.length];
  }

  getNextImage(): string {
    return this.images[(this.currentIndex + 1) % this.images.length];
  }

  prev(): void {
    this.currentIndex = (this.currentIndex - 1 + this.images.length) % this.images.length;
  }

  next(): void {
    this.currentIndex = (this.currentIndex + 1) % this.images.length;
  }
}




