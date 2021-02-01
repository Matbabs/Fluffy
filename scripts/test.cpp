#include <iostream>
#include <string>
using namespace std;

int main() {
	string fluffy = "Hello World";
	cout<<fluffy<<endl;
	int life = 4;
	cout<<"life is:"<<life<<endl;
	bool truth = true;
	string fat = "I'm not fat";
	fluffy = "I'm just fluffy";
	if(truth){
	cout<<fat<<" "<<fluffy<<endl;
	};
	if(!truth){
	cout<<"foo"<<endl;
	} else if(truth){
	cout<<"bar"<<endl;
	} else {
	cout<<"foo"<<endl;
	};
	for(int i=0; i<15; i++){
	if((i%3==0)&&(i%5==0)){
	cout<<"FizzBuzz"<<endl;
	} else if(i%3==0){
	cout<<"Fizz"<<endl;
	} else if(i%5==0){
	cout<<"Buzz"<<endl;
	} else {
	cout<<i<<endl;
	};
	};
	int k = 2;
	int i = 0;
	while(i<k){
	cout<<"blabla"<<endl;
	i = i+1;
	};
	auto write = [](){
	cout<<"write function"<<endl;
	};
	write(fun);
	auto compute
	auto x,y){
	return x+y;
	};
	auto res = compute;5,6
	cout<<res<<endl;
	return 0;
}