from time import time


def is_valid(n):
    d = None
    c = False

    while n > 0:
        if (d is not None) and (d == (n % 10)):
            if c:
                return False
            c = True
        else:
            c = False

        d = n % 10
        n = n // 10

    return True


def generate_valid_number_list():
    number_list = []

    number_list.extend([i for i in range(10, 99) if is_valid(i)])
    number_list.extend([i for i in range(1000, 9999) if is_valid(i)])
    number_list.extend([i for i in range(100000, 999999) if is_valid(i)])

    return number_list


def format(number_list):
    formatted_list = '\n'.join(number_list)

    return formatted_list


if __name__ == '__main__':
    t0 = time()

    number_list = generate_valid_number_list()
    # formatted_list = format(number_list)
    # with open('valid_station_numbers-py.txt', 'w') as f:
    #     f.write(formatted_list)

    t1 = time()
    dt = t1 - t0
    print(dt * 1000)
