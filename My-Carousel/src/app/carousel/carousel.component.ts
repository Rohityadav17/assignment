import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-carousel',
  templateUrl: './carousel.component.html',
  styleUrls: ['./carousel.component.css']
})
export class CarouselComponent implements OnInit {
  images: string[] = ['https://images.pexels.com/photos/9992332/pexels-photo-9992332.jpeg?auto=compress&cs=tinysrgb&w=600','https://images.pexels.com/photos/9992330/pexels-photo-9992330.jpeg?auto=compress&cs=tinysrgb&w=600','https://images.pexels.com/photos/9992435/pexels-photo-9992435.jpeg?auto=compress&cs=tinysrgb&w=600','https://images.pexels.com/photos/4676400/pexels-photo-4676400.jpeg?auto=compress&cs=tinysrgb&w=600']; 
  currentIndex = 0;

  constructor() {}

  ngOnInit(): void {}

  getVisibleImages(): string[] {
    const visibleImages: string[] = [];
    for (let i = -1; i <= 1; i++) {
      const index = (this.currentIndex + i + this.images.length) % this.images.length;
      visibleImages.push(this.images[index]);
    }
    return visibleImages;
  }

  prev(): void {
    this.currentIndex = (this.currentIndex - 1 + this.images.length) % this.images.length;
  }

  next(): void {
    this.currentIndex = (this.currentIndex + 1) % this.images.length;
  }
}
