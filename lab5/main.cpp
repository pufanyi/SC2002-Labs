#include <iostream>
#include <string>
#include <utility>
#include <vector>

enum COLOR {
    Green, Blue, White, Black, Brown
};

class Animal {
public :
    Animal() : _name("unknown"), _color(Black) {
        std::cout << "constructing Animal object " << _name << std::endl;
    }

    virtual ~Animal() {
        std::cout << "destructing Animal object " << _name << std::endl;
    }

    virtual void eat() const {
        std::cout << "Animal eats" << std::endl;
    }

    virtual void speak() const {
        std::cout << "Animal speaks " << std::endl;
    }

    Animal(std::string s, const COLOR &c) : _name(std::move(s)), _color(c) {
        std::cout << "constructing Animal object " << _name << std::endl;
    }

    virtual void move() const = 0;

private :
    COLOR _color;
protected:
    std::string _name;
};

class Mammal : public Animal {
public:
    virtual void eat() const {
        std::cout << "Mammal eats" << std::endl;
    }

    Mammal(const std::string &name, const COLOR color) : Animal(name, color) {
        std::cout << "constructing Mammal object " << name << std::endl;
    }

    void speak() const override {
        std::cout << "Mammal speaks" << std::endl;
    }

    void move() const override {
        std::cout << "Mammal moves" << std::endl;
    }

    virtual void eat() {
        std::cout << "Mammal eats" << std::endl;
    }

    ~Mammal() override {
        std::cout << "destructing Mammal object " << _name << std::endl;
    }
};

class Dog : public Mammal {
public:
    Dog(const std::string &name, const COLOR color, std::string owner) : Mammal(name, color), owner(std::move(owner)) {
        std::cout << "constructing Dog object " << name << std::endl;
    }

    void speak() const override {
        std::cout << "Dog Woof" << std::endl;
    }

    void move() const override {
        std::cout << "Dog moves" << std::endl;
    }

    void eat() const override {
        std::cout << "Dog eats" << std::endl;
    }

    ~Dog() override {
        std::cout << "destructing Dog object " << _name << std::endl;
    }

private:
    std::string owner;
};

class Cat : public Mammal {
public:
    Cat(const std::string &name, const COLOR color) : Mammal(name, color) {
        std::cout << "constructing Cat object " << name << std::endl;
    }

    void speak() const override {
        std::cout << "Cat Meow" << std::endl;
    }

    void eat() const override {
        std::cout << "Cat eats" << std::endl;
    }

    void move() const override {
        std::cout << "Cat moves" << std::endl;
    }

    ~Cat() override {
        std::cout << "destructing Cat object " << _name << std::endl;
    }
};

class Lion : public Mammal {
public:
    Lion(const std::string &name, const COLOR color) : Mammal(name, color) {
        std::cout << "constructing Lion object " << name << std::endl;
    }

    void speak() const override {
        std::cout << "Lion Roar" << std::endl;
    }

    void eat() const override {
        std::cout << "Lion eats" << std::endl;
    }

    void move() const override {
        std::cout << "Lion moves" << std::endl;
    }

    ~Lion() override {
        std::cout << "destructing Lion object " << _name << std::endl;
    }
};

COLOR getColor() {
    int opt = 0;
    std::cout << "Select the color of the animal :\n"
                 "(1) Green (2) Blue (3) White (4) Black (5) Brown" << std::endl;
    std::cin >> opt;
    switch (opt) {
        case 1:
            return Green;
        case 2:
            return Blue;
        case 3:
            return White;
        case 4:
            return Black;
        case 5:
            return Brown;
        default:
            std::cout << "Invalid option, defaulting to Black" << std::endl;
            return Black;
    }
}

std::ostream &operator<<(std::ostream &os, const COLOR &color) {
    switch (color) {
        case Green:
            os << "Green";
            break;
        case Blue:
            os << "Blue";
            break;
        case White:
            os << "White";
            break;
        case Black:
            os << "Black";
            break;
        case Brown:
            os << "Brown";
            break;
        default:
            os << "Black";
            break;
    }
    return os;
}

std::string getName() {
    std::string name;
    std::cout << "Enter the name of the animal : " << std::endl;
    std::cin >> name;
    return name;
}

std::string getOwner() {
    std::string owner;
    std::cout << "Enter the owner of the dog : " << std::endl;
    std::cin >> owner;
    return owner;
}

void display() {
    std::vector<Animal *> animals;

    while (true) {
        int opt = 0;
        std::cout << "Select the animal to send to Zoo :\n"
                     "(1) Dog (2) Cat (3) Lion (4) Move all animals (5) Quit" << std::endl;
        std::cin >> opt;
        switch (opt) {
            case 1:
                animals.push_back(new Dog(getName(), getColor(), getOwner()));
                break;
            case 2:
                animals.push_back(new Cat(getName(), getColor()));
                break;
            case 3:
                animals.push_back(new Lion(getName(), getColor()));
                break;
            case 4:
                for (const auto &animal: animals) {
                    animal->move();
                    animal->speak();
                    animal->eat();
                }
                break;
            case 5:
                for (const auto &animal: animals) {
                    delete animal;
                }
                return;
            default:
                std::cout << "Invalid option" << std::endl;
                break;
        }
    }
}

int main() {
//    Animal a;
//    a.speak();
//    Animal b("dog", Green);
//    b.speak();
//
//    std::cout << "===========================" << std::endl;
//
//    Mammal m("cat", Blue);
//    m.speak();
//
//    std::cout << "===========================" << std::endl;
//
//    Dog d("dog", White);
//    d.speak();
//
//    std::cout << "===========================" << std::endl;
    display();
    std::cout << "Program exiting ... " << std::endl;
    return 0;
}
