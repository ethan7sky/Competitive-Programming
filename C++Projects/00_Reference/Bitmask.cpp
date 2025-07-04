
int n;

int main() {

    //subset over mask over all possible masks
    for(int mask=0; mask < (1<<n); mask++){
        for(int submask = mask; submask != 0; submask = (submask-1)&mask) {
            int subset = mask ^ submask; //variable subset will be strictly increasing in this inner for loop
        }
    }

    //bitmask over primes
    
}