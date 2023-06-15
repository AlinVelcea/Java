# [P2] Java Class Hierarchy - 'Share Surprises' Application

The following application aims to deepen the design concepts of the class hierarchy:
- inheritance
- composition and aggregation
- encapsulation
- implementation of wrapper methods and use of delegation
- design and design of a class architecture
- upcasting
- design and use of interfaces


## Architecture

Implementing an application designed to manage a set of surprises.


### 1. Types of surprises

Each surprise will implement the following interface, which allows the "opening" of the surprise.

```
public interface ISurprise {
 
  // Opens the surprise and enjoys it
  void enjoy();
}
```

Create 3 types of surprises:
1. FortuneCookie - the person will receive a symbolic message.
2. Candies - the surprise contains a random number of candies of a certain type.
3. MinionToy - the surprise will be a minion toy.

Each surprise class will also contain a static method _'generate()'_, which will create a surprise of that type.


### 2. Storage of surprises

All surprises will be stored in various types of containers (bags), which will dictate the storage and especially the order in which the surprises will be divided.

Each container will implement the common interface:

```
    public interface IBag {
     
    	//rest of the code here

    }

```

And the following types of "bags of surprises" are implemented:

- a bag that will give the gifts inside in a random order;
- a bag that will give the gifts in the order in which they were placed (_FIFO_);
- a bag that will give the gifts in reverse order of introduction (_LIFO_).


### 3. Creating surprises

To generate a set of random surprises, we will implement a _'GatherSurprises'_ class, which will contain:

- a method which receives an integer and returns an array containing that number of surprises.

- a method which will return a single surprise.

### 4. Creating containers

The common interface for any container builder will be:

```
    public interface IBagFactory {

    	//create bags
      IBag makeBag(String type);
    }

```

Depending on the value of the parameter, a new collection will be created: _"RANDOM"_ / _"FIFO"_ / _"LIFO"_.


### 5. Sharing surprises

We will implement a mechanism to share surprises.
For this, the abstract class 'AbstractGiveSurprises' is defined with a series of specifications and methods.

The abstract class will be extended by 3 types of classes as follows:

1. _'GiveSurpriseAndApplause'_ 
2. _'GiveSurpriseAndSing'_  
3. _'GiveSurpriseAndHug'_  

Each class will display an appropriate message.


### 6. Testing

Some usage and testing scenarios to see the behavior of the application.
