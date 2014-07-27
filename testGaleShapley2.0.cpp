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
	vector <char> menNames(n);
	vector <char> womenNames(n);
	vector <vector <int> > menPrefs(n);
	vector <vector <int> > womenPrefs(n);
	char nameCounterMen = 'A';
	char nameCounterWomen = 'a';
    //OUTPUT N AND T
    printf ("Output T = [%d] and N = [%d]\n", t, n);
    fprintf(outputFile, "%d\n", n);
    fprintf(outputFile, "%d\n", t);
    //Generate correct number of tests
    for (int numTests = 0; numTests < t; numTests++) {
    	nameCounterMen = 'A';
    	nameCounterWomen = 'a';
        //OUTPUT NAMES (MEN THEN WOMEN ON SEPARATE LINE FOR SEPARATE GENDER)
    	//Name and output array for men's names
    	for (int counter = 0; counter < n; counter++) {
			menNames[counter] = nameCounterMen;
    		printf ("Output array for men's names [%c]\n", menNames[counter]);
    		fprintf(outputFile, "%c ", menNames[counter]);
    		nameCounterMen++;
    	}
    	fprintf(outputFile, "\n");
    	//Name and output array for women's names
    	for (int counter = 0; counter < n; counter++) {
			womenNames[counter] = nameCounterWomen;
    		printf ("Output array for women's names [%c]\n", womenNames[counter]);
    		fprintf(outputFile, "%c ", womenNames[counter]);
            nameCounterWomen++;
    	}
    	fprintf(outputFile, "\n");
        //CREATE PREFERENCE LISTS
		for (int i = 0; i < n; i++) {
			for (int j = 1; j <= n; ++j) {
				menPrefs[i].push_back(j);
				womenPrefs[i].push_back(j);
			}
			random_shuffle(menPrefs[i].begin(), menPrefs[i].end());
			random_shuffle(womenPrefs[i].begin(), womenPrefs[i].end());
			for (int k = 0; k < n; k++) {
				printf ("Output array for men's preferences [%d]\n", menPrefs[i][k]);
				fprintf(outputFile, "%d ", menPrefs[i][k]);
			}
    		fprintf(outputFile, "\n");
			for (int k = 0; k < n; k++) {
				printf ("Output array for women's preferences [%d]\n", womenPrefs[i][k]);
				fprintf(outputFile, "%d ", womenPrefs[i][k]);
			}
    		fprintf(outputFile, "\n");
		}
        //OUTPUT PREFERENCE LISTS (MEN THEN WOMEN ON SEPARATE LINE FOR SEPARATE GENDER)
		//Men Preferences
		fprintf(outputFile, "\n");
        //Women Preferences
        fprintf(outputFile, "\n");
    }
    //CLOSE FILES
    fclose(outputFile);
}