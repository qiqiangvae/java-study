template <class T>
#define NULL 0
class CBook
{
private:
    char *name;

public:
    CBook(char *name)
    {
        this->name = name;
    }

    ~CBook()
    {
        if (name != NULL)
        {
            free(name);
            name = NULL;
        }
    }
    const char *getName()
    {
        return this->name;
    }
};