import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-carousel',
  templateUrl: './carousel.component.html',
  styleUrls: ['./carousel.component.css']
})
export class CarouselComponent implements OnInit {
  @Input() images: string[] = []; 
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




