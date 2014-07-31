#include <cstdio>
#include <cstdlib>
#include <cassert>
#include <vector>
#include <algorithm>

using namespace std;

void generateRandomTests(int t, int n);

int main (int argc, char *argv[]) {
	assert (argc == 3);
	int n = atoi(argv[1]);
	int t = atoi(argv[2]);
	//DEFINE 'N' AND 'T'
	//CALL THE FUNCTIONS
	generateRandomTests(t, n);
	return EXIT_SUCCESS;
}

//Generate Random Tests
void generateRandomTests(int t, int n) {
    //OPEN FILES	
    char buffer[50];
    sprintf(buffer, "matchTests[%dx%dWith%dTests.txt", n, n, t);
	FILE *outputFile = fopen(buffer, "w");
	if (outputFile == NULL)
    {
        printf("Error opening file!\n");
    }
	//t = tests
	//n = length of matrix
	vector <int> menNames(n);
	vector <int> womenNames(n);
	vector <vector <int> > menPrefs(n);
	vector <vector <int> > womenPrefs(n);
	int nameCounterMen = 1;
	int nameCounterWomen = 1;
	int iterations = 0;
    //OUTPUT N AND T
    printf("%d\n", n);
    printf("%d\n", t);
    fprintf(outputFile, "%d\n", n);
    fprintf(outputFile, "%d\n", t);
    //Generate correct number of tests
	for (int i = 0; i < n; i++) {
	   for (int j = 1; j <= n; j++) {
			menPrefs[i].push_back(j);
			womenPrefs[i].push_back(j);
		}
	}	
   for (int numTests = 0; numTests < t; numTests++) {
    	nameCounterMen = 1;
    	nameCounterWomen = 1;
        //OUTPUT NAMES (MEN THEN WOMEN ON SEPARATE LINE FOR SEPARATE GENDER)
    	//Name and output array for men's names
    	printf("Men's Names\n");
    	for (int counter = 0; counter < n; counter++) {
			menNames[counter] = nameCounterMen;
    		printf("%d ", menNames[counter]);
    		fprintf(outputFile, "%d ", menNames[counter]);
    		nameCounterMen++;
    	}
    	fprintf(outputFile, "\n");
    	printf("\nWomen's Names\n");
    	//Name and output array for women's names
    	for (int counter = 0; counter < n; counter++) {
			womenNames[counter] = nameCounterWomen;
    		printf("%d ", menNames[counter]);
    		fprintf(outputFile, "%d ", womenNames[counter]);
            nameCounterWomen++;
    	}
    	fprintf(outputFile, "\n");
        //CREATE PREFERENCE LISTS
		for (int i = 0; i < n; i++) {
			random_shuffle(menPrefs[i].begin(), menPrefs[i].end());
			random_shuffle(womenPrefs[i].begin(), womenPrefs[i].end());
			printf("\nMan %d's Prefs\n", i);
			for (int k = 0; k < n; k++) {
				printf("%d ", menPrefs[i][k]);
				fprintf(outputFile, "%d ", menPrefs[i][k]);
			}
    		fprintf(outputFile, "\n");
    		printf("\nWoman %d's Prefs\n", i);
			for (int k = 0; k < n; k++) {
				printf("%d ", womenPrefs[i][k]);
				fprintf(outputFile, "%d ", womenPrefs[i][k]);
			}
    		fprintf(outputFile, "\n");
		}
        //OUTPUT PREFERENCE LISTS (MEN THEN WOMEN ON SEPARATE LINE FOR SEPARATE GENDER)
		//Men Preferences
		fprintf(outputFile, "\n");
        //Women Preferences
        fprintf(outputFile, "\n");
        iterations++;
     printf ("\nCompleted Iteration [%d]\n", iterations);

    }
    //CLOSE FILES
    fclose(outputFile);
}