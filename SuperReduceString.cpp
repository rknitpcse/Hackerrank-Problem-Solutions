/*
Problem: Super Reduce String
Problem Link: https://www.hackerrank.com/challenges/reduced-string/problem
*/
#include<bits/stdc++.h>
using namespace std;
/*
@Rakesh Kumar
Master of Technology in Computer Science
University of Hyderabad
Bachelor of Technology in Computer Science and Engineering
National Institute of Technology Patna
*/
int main()
{
	string line="",temp="";
	getline(cin, line, '\n');
	for(int i=1;i<line.length();i++)
	{
		if(line[i]==line[i-1])
		{
			line.erase(i-1,i+1);
			i=0;
		}
	}
	(line.size()>0)? cout<<line : cout<<"Empty String";
	return 0;
}
