/*
Problem: Super Reduce String
Problem Link: https://www.hackerrank.com/challenges/reduced-string/problem
*/

#include<bits/stdc++.h>
#define MAXALPHA 26
using namespace std;
/*
@Rakesh Kumar
Master of Technology in Computer Science
University of Hyderabad
Bachelor of Technology in Computer Science and Engineering
National Institute of Technology Patna
*/
void checkFreq(string line)
{
	int n =  line.size();
	unsigned freq[MAXALPHA];
	memset(freq, 0, sizeof(freq));
	for(int i=0;i<n;i++)
		freq[line[i] - 'a']++;
	/*  Displaying each character frequency
	for(int i=0; i<n; i++)
	{
		if(freq[line[i] - 'a']!=0)
			cout<<line[i]<<"-"<<freq[line[i] - 'a']<<" ";	
	}
	cout<<endl;
	*/	
	//updating the each character frequency
	for(int i=0; i<n; i++)
	{
		if(freq[line[i]-'a'] % 2 == 0)
			freq[line[i]-'a']=0;	
		else
			freq[line[i]-'a']=1;		
	}
	string res="";
	for(int i=0; i<n; i++)
	{
		while(freq[line[i] - 'a']-->0)
			res+=char(line[i]);
		freq[line[i] - 'a'] = 0;	
	}
	if(res.size()>0)
		cout<<res<<endl;
	else
		cout<<"Empty String"<<endl;	
}
int main()
{
	string line="",temp="";
	getline(cin, line, '\n');
	checkFreq(line);	
	return 0;
}
