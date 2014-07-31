#include <cstdio>
#include <cstdlib>
#include <cassert>
#include <vector>
#include <algorithm>
#include <string>
#include <ctime>

using namespace std;

#define TRUE 0
#define FALSE 1

void generateRandomTests(int t, int n);

typedef struct _person {
	int name;
	string bloodType;
	string eggs;
	string vegOrVeg;
    string highFatD;
    string oilAndButter;
    string fastFood;
} person;


int main (int argc, char *argv[]) {
	assert (argc == 3);
	unsigned long long n = atoi(argv[1]);
	long long t = atoi(argv[2]);
	//DEFINE 'N' AND 'T'
	//CALL THE FUNCTIONS
	generateRandomTests(t, n);
	return EXIT_SUCCESS;
}

//Generate Random Tests
void generateRandomTests(int t, int n) {
    //OPEN FILES	
    char buffer[50];
    sprintf(buffer, "KCI_Tests[%lluPeopleWith%lluTests.txt", n, t);
	FILE *outputFile = fopen(buffer, "w");
	if (outputFile == NULL)
    {
        printf("Error opening file!\n");
    }
    srand (time(NULL));
	//t = tests
	//n = number of tests
	
    //Generator
	//How many tests
	printf("%llu\n%llu\n", n, t);
	fprintf(outputFile, "%llu\n%llu\n", n, t);
	for (int i = 0; i<t; i++) {
		for (unsigned long long j = 0; j<n; j++) {
			person Person;
		
			Person.name = 1;
		
			int randomNumber = rand() %8;
			switch (randomNumber) {
				case 0:
					Person.bloodType="A+";
					break;
				case 1: 
					Person.bloodType="A-";
					break;
				case 2: 
					Person.bloodType="B+";
					break;
				case 3: 
					Person.bloodType="B-";
					break;
				case 4: 
					Person.bloodType="O+";
					break;
				case 5:
					Person.bloodType="O-";
					break;
				case 6: 
					Person.bloodType="AB+";
					break;
				case 7: 
					Person.bloodType="AB-";
					break;
			}
		
			randomNumber = rand() %4;
			switch (randomNumber) {
				case 0:
					Person.eggs = "Rarely";
					break;
				case 1: 
					Person.eggs = "Sometimes";
					break;
				case 2: 
					Person.eggs = "Often";
					break;
				case 3: 
					Person.eggs = "Most of the time";
					break;
			}
		
			randomNumber = rand() %3;
			switch (randomNumber) {
				case 0:
					Person.vegOrVeg = "Vegetarian";
					break;
				case 1: 
					Person.vegOrVeg = "Vegan";
					break;
				case 2: 
					Person.vegOrVeg = "None of the above";
					break;
			}
		
			randomNumber = rand() %4;
			switch (randomNumber) {
				case 0:
					Person.highFatD = "Rarely";
					break;
				case 1: 
					Person.highFatD = "Sometimes";
					break;
				case 2: 
					Person.highFatD = "Often";
					break;
				case 3: 
					Person.highFatD = "Most of the time";
					break;
			}
		
			randomNumber = rand() %4;
			switch (randomNumber) {
				case 0:
					Person.oilAndButter = "Rarely";
					break;
				case 1: 
					Person.oilAndButter = "Sometimes";
					break;
				case 2: 
					Person.oilAndButter = "Often";
					break;
				case 3: 
					Person.oilAndButter = "Most of the time";
					break;
			}
		
			randomNumber = rand() %5;
			switch (randomNumber) {
				case 0:
					Person.fastFood = "0";
					break;
				case 1: 
					Person.fastFood = "1-3";
					break;
				case 2: 
					Person.fastFood = "4-6";
					break;
				case 3: 
					Person.fastFood = "7-9";
					break;
				case 4:
					Person.fastFood ="10+";
					break;
			}
		
			//Output
			fprintf(outputFile, "%d,%s,%s,%s,%s,%s,%s\n", Person.name, Person.bloodType.c_str(), Person.eggs.c_str(), Person.vegOrVeg.c_str(), Person.highFatD.c_str(), Person.oilAndButter.c_str(), Person.fastFood.c_str());
		}
		printf ("Iteration [%d]\n", i+1);
		fprintf (outputFile, "\n");
	}
}
