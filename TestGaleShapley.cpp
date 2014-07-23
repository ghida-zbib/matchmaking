#include <cstdio>
#include <cstdlib>
#include <cassert>
#include <vector>

using namespace std;

void openFiles(void);
void generateRandomTests(int t, int n);
void closeFiles(void);

int main (int arc, char *argv[]) {
	openFiles();
	generateRandomTests();
	closeFiles();
	return EXIT_SUCCESS;
}
//Open Files
void openFiles(void) {
	FILE *outputFile = fopen("matchTests.txt", "w");
	if (outputFile == NULL)
    {
        printf("Error opening file!\n");
    }
}
//Generate Random Tests
void generateRandomTests(int n, int t) {
	//t = tests...n = length of matrix
	int numTests = 0;
	char menNames[n];
	char womenNames[n];
	vector <int> menPrefs;
	vector <int> menPrefs;
	int counter = 0;
	int nameCounterMen = 65;
	int nameCounterWomen = <ascii here>;
    //Generate correct number of tests
    while (numTests < t) {
    	//Name array for men
    	while (counter < n) {
			menNames.push(nameCounterMen);
			womenNames.push(nameCounterWomen);
			nameCounterMen++;
			nameCounterWomen++;
		}
    	fprintf(outputFile, "%d\n", <array>);
		counter++;
    }
    
    
}
//Close Files
void closeFiles(void) {
    fclose(outputFile);
    
}
