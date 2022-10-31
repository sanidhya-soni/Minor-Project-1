// package source;

// public class Rack
// {
//     int section_capacity;
//     int sections;
//     Tray[][] rack;

//     Rack(int sections, int section_capacity)
//     {
//         this.sections = sections;
//         this.section_capacity = section_capacity;
//         this.rack = new Tray[this.sections][this.section_capacity];
//     }

//     void add(Tray tray)
//     {
//         if(hasSpace())
//         {
//             rack[top++] = tray;
//             System.out.println("Tray added succesfully in rack!");
//         }
//         else
//             System.out.println("Rack is full, Get a new one!");
//     }

//     void pop()
//     {
//         if(!hasSpace())
//         {
//             top--;
//             System.out.println("Tray removed succesfully!");
//         }
//         else
//             System.out.println("Rack is Empty!");
//     }

//     boolean hasSpace()
//     {
//         return this.top < this.capacity;
//     }
// }
