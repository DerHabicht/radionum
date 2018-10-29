#include <chrono>
#include <fstream>
#include <iostream>
#include <string>
#include <vector>

using namespace std;
using namespace std::chrono;

bool is_valid(int n) {
    int d;
    bool dv = false;
    bool c = false;

    while (n > 0) {
        if (dv && (d == (n % 10))) {
            if (c)
                return false;
            c = true;
        } else {
            dv = true;
            c = false;
        }

        d = n % 10;
        n /= 10;
    }

    return true;
}


vector<int> generate_valid_number_list() {
    vector<int> number_list;

    for (int i = 10; i <= 99; ++i)
        if ( is_valid(i) )
            number_list.push_back(i);

    for (int i = 1000; i <= 9999; ++i)
        if ( is_valid(i) )
            number_list.push_back(i);

    for (int i = 100000; i <= 999999; ++i)
        if ( is_valid(i) )
            number_list.push_back(i);

    return number_list;
}

string format(vector<int> number_list) {
    string formatted_list = "";

    for (int x : number_list)
        formatted_list += to_string(x) + "\n";

    return formatted_list;
}

int main() {
    auto t0 = high_resolution_clock::now();

    auto number_list = generate_valid_number_list();
    /*
    auto formatted_list = format(number_list);
    ofstream file;
    file.open("valid_station_numbers-cpp.txt");
    file << formatted_list;
    file.close();
    */

    auto t1 = high_resolution_clock::now();
    auto dt = duration_cast<milliseconds>(t1 - t0);

    cout << dt.count() << endl;

    return 0;
}
